set -e

psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE DATABASE jnmodas_gestao_produto_ms_db;
    CREATE DATABASE jnmodas_gestao_cliente_ms_db;
    CREATE DATABASE jnmodas_gestao_fornecedor_ms_db;
    CREATE DATABASE jnmodas_gestao_emprestimo_ms_db;
EOSQL