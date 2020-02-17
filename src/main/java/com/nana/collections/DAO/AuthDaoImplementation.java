//package com.nana.collections.DAO;
//
//import com.nana.collections.Config.JDBCTemplateConfig;
//import com.nana.collections.Models.User;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.InvalidDataAccessApiUsageException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.SqlOutParameter;
//import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Types;
//import java.util.Map;
//
//@Repository
//
//public class AuthDaoImplementation implements AuthDAO {
//
//    @Value("Collection_PKG")
//    private String collectionsPackage;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    Environment environment;
//
//    final static Logger LOGGER = LogManager.getLogger(AuthDaoImplementation.class);
//
//    public String create(User user) {
//
//        String response = null;
//
//        try {
//            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
//            simpleJdbcCall.withProcedureName(collectionsPackage + ".create_user")
//                    .withoutProcedureColumnMetaDataAccess()
//                    .declareParameters(
//                            new SqlParameter("p_first_name", Types.VARCHAR),
//                            new SqlParameter("p_middle_name", Types.VARCHAR),
//                            new SqlParameter("p_last_name", Types.VARCHAR),
//                            new SqlParameter("p_gender", Types.VARCHAR),
//                            new SqlParameter("p_role", Types.VARCHAR),
//                            new SqlParameter("p_phone", Types.VARCHAR),
//                            new SqlParameter("p_email", Types.VARCHAR),
//                            new SqlParameter("p_address", Types.VARCHAR),
//                            new SqlOutParameter("p_msg", Types.VARCHAR))
//                    .compile();
//
//            SqlParameterSource inParams = new MapSqlParameterSource()
//                    .addValue("p_first_name", user.getFirstName() == null ? "" : user.getFirstName())
//                    .addValue("p_middle_name", user.getMiddleName() == null ? "" : user.getMiddleName())
//                    .addValue("p_last_name", user.getLastName() == null ? "" : user.getLastName())
//                    .addValue("p_gender", user.getGender() == null ? "" : user.getGender())
//                    .addValue("p_role", user.getRole() == null ? "": user.getRole())
//                    .addValue("p_phone", user.getPhone()== null ? "": user.getPhone())
//                    .addValue("p_email", user.getEmail() == null ? "" : user.getEmail())
//                    .addValue("p_address", user.getAddress() == null ? "" : user.getAddress());
//            System.out.println(user.getRole());
//            Map<String, Object> returningResult = simpleJdbcCall.execute(inParams);
//            response = (String) returningResult.get("p_msg");
//
//        } catch (InvalidDataAccessApiUsageException e) {
//            e.printStackTrace();
//        }
//        return response;
//
//    }
//}
