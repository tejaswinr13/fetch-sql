package com.fetechservice.fetchservice.repository;


import com.fetechservice.fetchservice.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDetailsRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //  private static final String SQL_INSERT = "INSERT INTO dbo.user_details (patientid,rxNumber,storenum,daysSupply) values(:patientid,:rxNumber,:storenum,:daysSupply)";
      private static final String SQL_FETCH = "SELECT * from dbo.user_details WHERE patientid=:patientid";
   // private static final BeanPropertyRowMapper<UserDetails> ROW_MAPPER = new BeanPropertyRowMapper<>(UserDetails.class);


    public List<UserDetails> findById (String patientid) {
        final SqlParameterSource paramSource = new MapSqlParameterSource("patientid", patientid);
        return namedParameterJdbcTemplate.
                query(SQL_FETCH,
                paramSource, (resultSet, i) -> {
                    return toPatient(resultSet);
                });
    }

    private UserDetails toPatient(ResultSet resultSet) throws SQLException {
        UserDetails userDetails = new UserDetails();
        userDetails.setPatientid(resultSet.getString("patientid"));
        userDetails.setDaysSupply(resultSet.getString("daysSupply"));
        userDetails.setRxNumber(resultSet.getString("rxNumber"));
        userDetails.setStorenum(resultSet.getString("storenum"));

        return  userDetails;
    }
}
