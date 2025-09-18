# Praxis-V

📌 **Sistema para Gestão de Projetos, Equipes e Tarefas** desenvolvido em **Java (JavaFX)**.  
Atualmente o sistema utiliza **banco de dados em memória** (para fins de desenvolvimento e testes), com previsão futura de migração para **MySQL** para persistência real dos dados.  

O objetivo do projeto é fornecer uma solução desktop para **controle de usuários, projetos, equipes e tarefas**, com relatórios de desempenho e diferentes perfis de acesso.  

---

## 📑 Estrutura de Páginas / Módulos

### 🔐 1. Login ✅
- Tela inicial com autenticação no banco (em memória).  
- Controle de acesso por perfil (**Administrador, Gerente, Colaborador**).  

### 👤 2. Usuários ✅
- Cadastro de: nome, CPF, e-mail, cargo, login e senha.  
- Definição de perfis de acesso.  
- Manutenção (edição/exclusão) de usuários.  

### 📂 3. Projetos ✅
- Cadastro de projeto (nome, descrição, datas, status).  
- Cada projeto tem **um gerente responsável**.  
- Vínculo futuro com equipes e tarefas.  

---

### 👥 4. Equipes 🚧 *(planejado)*
- Cadastro de equipes com nome e descrição.  
- Associação de usuários como membros.  
- Uma equipe pode atuar em múltiplos projetos.  

### 🔄 5. Alocação de Equipes a Projetos 🚧 *(planejado)*
- Associação entre projetos e equipes (N:N).  

### ✅ 6. Tarefas 🚧 *(planejado)*
- Cadastro de tarefas vinculadas a projetos.  
- Atribuição a um usuário responsável.  
- Campos: título, descrição, status, datas previstas e reais.  

### 📊 7. Relatórios / Dashboards 🚧 *(planejado)*
- Resumo de andamento dos projetos.  
- Desempenho por colaborador.  
- Projetos com risco de atraso.  

---

## 🛠️ Tecnologias

- **Java 21+**  
- **JavaFX 21** (FXML, Scene Builder)  
- **Banco em memória** *(atual)*  
- **MySQL 8+** *(planejado para o futuro)*  
- **Maven** (gerenciamento de dependências)  

---

## 📂 Estrutura do Projeto

```
src/main/java/
 ├── application/          # Inicialização e entrypoint (App, Launcher, ScreenUtils)
 ├── domain/               # Entidades de domínio (Usuario, Projeto, Equipe, Tarefa)
 │   ├── entities/
 │   ├── enums/
 │   └── validators/
 ├── infrastructure/       # Persistência e acesso a dados (UsuarioDatabase, ProjetoDatabase)
 └── praxisv/              
     ├── controllers/      # Controladores JavaFX
     │   └── forms/        # Lógica das telas de formulário
     └── App.java          # Classe principal
resources/
 └── praxisv/
     ├── css/              # Estilos
     └── pages/            # Arquivos FXML das telas
```

---

## ▶️ Como Rodar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seuusuario/Praxis-V.git
   cd Praxis-V
   ```

2. **Banco de dados**
   - Atualmente o projeto usa **banco em memória** (não precisa de configuração extra).  
   - Futuramente será migrado para **MySQL**.  

3. **Compile e rode com Maven**
   ```bash
   mvn clean javafx:run
   ```

---

## 📌 Próximos Passos

- [ ] Implementar cadastro de **Equipes**  
- [ ] Criar associação **Equipes ↔ Projetos**  
- [ ] Implementar cadastro de **Tarefas**  
- [ ] Gerar **relatórios e dashboards**  
- [ ] Migrar persistência para **MySQL**  
- [ ] Criar histórico de alterações em tarefas e projetos  
- [ ] Implementar logs de acesso  
- [ ] Adicionar validações de formulários  
- [ ] Exportar relatórios em PDF/Excel  

---

## 📸 Telas Esperadas

- **Login** – autenticação de usuário.  
- **Cadastro de Usuários** – criação e manutenção de perfis.  
- **Cadastro de Projetos** – gerenciamento de ciclo de vida de projetos.  
- **Cadastro de Equipes** *(planejado)*.  
- **Cadastro de Tarefas** *(planejado)*.  
- **Relatórios/Dashboard** *(planejado)*.  

---

🔒 **Praxis-V** é um projeto acadêmico/didático, podendo ser expandido para cenários reais de gestão de equipes e projetos.  
