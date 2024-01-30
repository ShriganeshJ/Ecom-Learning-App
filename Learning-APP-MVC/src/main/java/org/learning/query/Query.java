package org.learning.query;

public class Query {
    public static final String EMPLOYEE_SELECT_ALL="SELECT EMP_ID,FIRST_NAME,LAST_NAME,CITI,MOBILE,EMAIL,DEPARTMENT,SALARY,DOB FROM EMPLOYEE";
    public static final String EMPLOYEE_SELECT_BY_ID="SELECT EMP_ID,FIRST_NAME,LAST_NAME,CITI,MOBILE,EMAIL,DEPARTMENT,SALARY,DOB FROM EMPLOYEE WHERE EMP_ID=?";
    public static final String DELETE_EMPLOYEE ="DELETE FROM EMPLOYEE WHERE EMP_ID=?";
    public static final String UPDATE_EMPLOYEE_MOBILE="UPDATE EMPLOYEE SET MOBILE=? WHERE EMP_ID=?";
    public static final String UPDATE_EMPLOYEE_EMAIL="UPDATE EMPLOYEE SET EMAIL=? WHERE EMP_ID=?";
    public static final String UPDATE_EMPLOYEE_DEPARTMENT="UPDATE EMPLOYEE SET DEPARTMENT=? WHERE EMP_ID=?";
    public static  final String INSERT_EMPLOYEE ="INSERT INTO EMPLOYEE (EMP_ID,FIRST_NAME,LAST_NAME,CITI,MOBILE,EMAIL,DEPARTMENT,SALARY,DOB) VALUES (?,?,?,?,?,?,?,?,?)";
}
