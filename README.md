# Notification Service

> API REST experimental para registrar e consultar notificações por destinatário e status.

**Stack:** Java 21 · Spring Boot 3 · Spring Data JPA · H2 · Maven  
**Status:** Projeto de estudo / portfólio

## Funcionalidades

- Registro de notificações via endpoint REST
- Listagem por destinatário e situação
- Consulta individual e remoção
- Separação em controller, service, repository e DTO

## Endpoints principais

| Método | Rota | Objetivo |
|---|---|---|
| `GET` | `/api/notifications` | Lista notificações |
| `GET` | `/api/notifications/{id}` | Consulta por ID |
| `GET` | `/api/notifications/recipient/{recipient}` | Filtra destinatário |
| `GET` | `/api/notifications/status/{status}` | Filtra status |
| `POST` | `/api/notifications/send` | Registra notificação |
| `DELETE` | `/api/notifications/{id}` | Exclui registro |

## Executar localmente

Requisitos: **JDK 21** e conexão com o banco configurada conforme `src/main/resources/application.properties`.

```bash
git clone https://github.com/fgscarvalho37-a11y/notification-service.git
cd notification-service
./mvnw spring-boot:run
```

No Windows, utilize `mvnw.cmd spring-boot:run`. A porta e as propriedades de banco dependem da configuração da aplicação.

## Organização

`controller` recebe as requisições; `service` centraliza regras; `repository` acessa dados; `model` e `dto` representam entidades e dados de entrada/saída.

## Notas

O endpoint /send é um fluxo de registro no serviço; não implica entrega real por e-mail, SMS ou push.

---

Desenvolvido por [Felipe Gomes](https://github.com/fgscarvalho37-a11y).