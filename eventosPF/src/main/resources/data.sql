-- Usuário ADMIN (id=1) — use esse no X-USER-ID para todas as requisições
INSERT INTO usuarios (nome, cpf, papel, deleted) VALUES ('Admin', '000.000.000-00', 'ADMIN', false);

-- Usuário comum (id=2) — para testar associação com evento
INSERT INTO usuarios (nome, cpf, papel, deleted) VALUES ('João Participante', '111.111.111-11', 'USER', false);

-- Dois eventos (id=1 e id=2)
INSERT INTO evento (nome, data, deleted) VALUES ('Hackathon Insper', '2026-06-15', false);
INSERT INTO evento (nome, data, deleted) VALUES ('Workshop Spring Boot', '2026-07-20', false);