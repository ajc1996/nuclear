package test;

import nuclear.dao.UserNuMapper;
import nuclear.model.UserNu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserNuMapperTest extends BaseTest {
    @Autowired
    private UserNuMapper um;
    @Test
    public void countByExample() throws Exception {
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        UserNu un = new UserNu();
        un.setUname("zhangsan");
        un.setUpassword("123456");
        um.insert(un);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}