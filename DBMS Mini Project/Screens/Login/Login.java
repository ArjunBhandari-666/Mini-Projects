class LoggedIn
{   
    String userName;
    LoggedIn(String role,String username)  
    { 
        if(role.equalsIgnoreCase("Student"))
        {
            StudentCreateTicket.main(username);
        }
        else if(role.equalsIgnoreCase("Head"))
        {
            HeadAssignTickets.main(username);
        }
        else if(role.equalsIgnoreCase("Super"))
        {
            SuperLogin.main(username);
        }
    }  
}