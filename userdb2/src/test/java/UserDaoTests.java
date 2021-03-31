import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
public class UserDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
       // UserDao userDao = new UserDao(new JejuConnectionMaker());
        User user = userDao.findByID(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String name = "허윤호";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
      //  UserDao userDao = new UserDao(new JejuConnectionMaker());
        userDao.insert(user);

        User insertadUser = userDao.findByID(user.getId());
        assertThat(user.getId(), greaterThan(0));
        assertThat(insertadUser.getId(), is(user.getId()));
        assertThat(insertadUser.getName(), is(user.getName()));
        assertThat(insertadUser.getPassword(), is(user.getPassword()));
    }

//    @Test
//    public void getHalla() throws SQLException, ClassNotFoundException {
//        Integer id = 1;
//        String name = "hulk";
//        String password = "1234";
//
//        UserDao userDao = new UserDao(new HallaconnectionMaker());
//        User user = userDao.findByID(id);
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
//    @Test
//    public void insertHalla() throws SQLException, ClassNotFoundException {
//        String name = "허윤호";
//        String password = "1111";
//
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        UserDao userDao = new UserDao(new HallaconnectionMaker());
//        userDao.insert(user);
//
//        User insertadUser = userDao.findByID(user.getId());
//        assertThat(user.getId(), greaterThan(0));
//        assertThat(insertadUser.getId(), is(user.getId()));
//        assertThat(insertadUser.getName(), is(user.getName()));
//        assertThat(insertadUser.getPassword(), is(user.getPassword()));
//    }
}
