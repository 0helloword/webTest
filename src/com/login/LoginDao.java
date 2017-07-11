package com.login;  
  
import java.sql.SQLException;  
import java.util.List;  
import java.util.Map;  
  
//import javax.mail.Flags.Flag;  
  
import com.jdbc.JdbcUtils;  
//DAO��һ���нӿں͸ýӿڵ�ʵ���࣡ �ӿ����ڹ淶ʵ���࣡ ʵ����һ���������ڲ������ݿ⣡
//һ������޸ģ����ӣ�ɾ�����ݿ�����Ĳ�������ƣ���д��һ��������DAO�� ���޸ģ����ӣ�ɾ�����ݿ����ʱ ֱ�ӵ��ù�����DAO�࣡  
public class LoginDao implements LoginService {  
  
    private JdbcUtils jdbcUtils;  
    public LoginDao() {  
        // TODO Auto-generated constructor stub  
        jdbcUtils = new JdbcUtils();  
    }  
  
    @Override  
    public boolean login(List<Object> params) {  
        // TODO Auto-generated method stub  
        boolean flag = false;  
          
        try {  
            jdbcUtils.getConnection();  
            String sql = "select * from userinfo where username = ? and pswd = ?";  
            Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);  
            flag = !map.isEmpty()?true:false;             
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }finally{  
              
        //�ر����ݿ�  
        jdbcUtils.releaseConn();  
              
        }  
          
        return flag;  
    }     
  
}  