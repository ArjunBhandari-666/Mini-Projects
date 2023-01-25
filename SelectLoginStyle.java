class LoggedIn 
{   
    String userName;
    LoggedIn(String role,String username)  
    { 
        if(role.equalsIgnoreCase("Student"))
        {
            LoggedInStudent.main(username);
        }
        else if(role.equalsIgnoreCase("Head"))
        {
            LoggedInHead.main(username);
        }
        else if(role.equalsIgnoreCase("Super"))
        {
            LoggedInEmp.main(username);
        }
    }  
}

