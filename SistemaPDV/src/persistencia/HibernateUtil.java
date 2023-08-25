package persistencia;

import entidade.Cidade;
import entidade.Compra;
import entidade.Estado;
import entidade.Fornecedor;
import entidade.ItensCompra;
import entidade.ItensVenda;
import entidade.Pessoa;
import entidade.Produto;
import entidade.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory factory;
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final ThreadLocal transactionThread = new ThreadLocal();

    public static Session getSession() {
        Session session = (Session) sessionThread.get();
        if ((session == null) || (!(session.isOpen()))) {
            session = factory.openSession();
            sessionThread.set(session);
        }
        return ((Session) sessionThread.get());
    }

    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
        }
    }

    public static void beginTransaction() {
        Transaction transaction = getSession().beginTransaction();
        transactionThread.set(transaction);
    }

    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.commit();
            transactionThread.set(null);
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.rollback();
            transactionThread.set(null);
        }
    }
//configuração do hibernate para conexão com banco de dados

    static {
        try {
            factory = new AnnotationConfiguration()
                    //                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    //                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    //                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/sistemapoo")
                    //Dialeto do banco de dados.
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                    //Drive JDBC do banco de dados.
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                    //url do banco, indica o caminho onde se encontra o banco de dados. Local, porta e nome do banco.
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/SistemaPdv")
                    //usuário do banco de dados
                    .setProperty("hibernate.connection.username", "postgres")
                    //senha do banco de dados
                    .setProperty("hibernate.connection.password", "postgres")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.c3p0.max_size", "10")
                    .setProperty("hibernate.c3p0.min_size", "2")
                    .setProperty("hibernate.c3p0.timeout", "5000")
                    .setProperty("hibernate.c3p0.max_statements", "10")
                    .setProperty("hibernate.c3p0.idle_test_period", "3000")
                    .setProperty("hibernate.c3p0.acquire_increment", "2")
                    .setProperty("show_sql", "true")
                    .setProperty("use_outer_join", "true")
                    .setProperty("hibernate.generate_statistics", "true")
                    .setProperty("hibernate.use_sql_comments", "true")
                    .setProperty("hibernate.format_sql", "true")
                    .addAnnotatedClass(Estado.class)
                    .addAnnotatedClass(Cidade.class)
                    .addAnnotatedClass(Pessoa.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Venda.class)
                    .addAnnotatedClass(ItensVenda.class)
                    .addAnnotatedClass(ItensCompra.class)
                    .addAnnotatedClass(Compra.class)
                    .addAnnotatedClass(Fornecedor.class)
                    .buildSessionFactory();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
