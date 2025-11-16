USE ae4_seguridad;

CREATE TABLE IF NOT EXISTS usuarios (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  role     VARCHAR(20)  NOT NULL,
  enabled  BOOLEAN      NOT NULL DEFAULT TRUE
);
