package domain.validators;

import domain.entities.Projeto;
import java.util.ArrayList;
import java.util.List;

public class ProjetoValidator {

    private final List<String> errors = new ArrayList<>();

    public boolean isValid(Projeto projeto) {
        errors.clear();

        if (projeto.getNome() == null || projeto.getNome().isBlank())
            errors.add("Nome do projeto não pode ser vazio");

        if (projeto.getDescricao() == null || projeto.getDescricao().isBlank())
            errors.add("Descrição não pode ser vazia");

        if (projeto.getDataInicio() == null)
            errors.add("Data de início obrigatória");

        if (projeto.getDataTerminoPrevista() == null)
            errors.add("Data de término prevista obrigatória");

        if (projeto.getDataInicio() != null && projeto.getDataTerminoPrevista() != null &&
                projeto.getDataInicio().isAfter(projeto.getDataTerminoPrevista()))
            errors.add("Data de término prevista deve ser depois da data de início");

        if (projeto.getStatus() == null)
            errors.add("Status do projeto é obrigatório");

        if (projeto.getGerente() == null)
            errors.add("Projeto deve ter um gerente responsável");

        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }
}
