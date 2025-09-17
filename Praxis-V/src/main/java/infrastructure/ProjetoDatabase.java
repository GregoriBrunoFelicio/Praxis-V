package infrastructure;

import domain.enums.Perfil;
import domain.entities.Projeto;
import domain.enums.StatusProjeto;
import domain.entities.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDatabase {

    private static Usuario usuarioGerente = UsuarioDatabase.getAll()
            .stream()
            .filter(u -> u.getPerfil() == Perfil.GERENTE)
            .findFirst()
            .orElse(null);

    private static final List<Projeto> projetos = new ArrayList<>(
            List.of(
                    new Projeto(
                            "Projeto Alpha",
                            "Descrição do Projeto Alpha",
                            LocalDate.of(2024, 1, 1),
                            LocalDate.of(2024, 6, 1),
                            StatusProjeto.EM_ANDAMENTO,
                            usuarioGerente
                    ),
                    new Projeto(
                            "Projeto Beta",
                            "Descrição do Projeto Beta",
                            LocalDate.of(2024, 2, 1),
                            LocalDate.of(2024, 7, 1),
                            StatusProjeto.PLANEJADO,
                            usuarioGerente
                    ),
                    new Projeto(
                            "Projeto Gamma",
                            "Descrição do Projeto Gamma",
                            LocalDate.of(2024, 3, 1),
                            LocalDate.of(2024, 8, 1),
                            StatusProjeto.CONCLUIDO,
                            usuarioGerente
                    )
            )
    );

    private static int ultimoId = 0;

    public static void add(Projeto projeto) {
        projeto.setId(++ultimoId);
        projetos.add(projeto);
    }

    public static void update(Projeto projeto) {
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getId() == projeto.getId()) {
                projetos.set(i, projeto);
                break;
            }
        }
    }

    public static List<Projeto> getAll() {
        return new ArrayList<>(projetos);
    }

    public static Projeto getById(int id) {
        return projetos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void remove(int id) {
        projetos.removeIf(p -> p.getId() == id);
    }

    public static void clear() {
        projetos.clear();
        ultimoId = 0;
    }
}