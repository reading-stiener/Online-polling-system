# Online-Polling-system

Run TopMode.java to execute the main program 
  command: java Tester.java 

This program has three modes. The main menu, user mode and admin mode. 

1. The main menu: 
  Allows you to switch between user mode and admin mode or return to main menu 

2. User mode: 
  The mode in which any registered user will add his/her ideas and vote for ideas. Each user is allowed to offer upto five        ideas. 
  
  Methods: 
    # All methods below are constant time operations 
    i. addUser: Adds new user and takes them to user mode 
    ii. login <email>: Allows existing user to enter thier user mode 
    iii. idea: lists your ideas
    iv. addIdea: add new idea
    v. other <email>: shows other people's ideas
    vi. vote: allows you to vote for an idea
    vii. addIdea: add new idea
    viii. top: takes you back to top mode

3. Admin Mode: 
   i. candidate: show top rated candidate. This is a constant time operation as well
   ii. award: award top rated candidate

  

