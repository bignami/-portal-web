public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());

    }
    public JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
