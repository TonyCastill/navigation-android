# NAVIGATION #
## CONCEPTS ##
* **Nav Controller:** Keep track of a back stack in a state of composable screens. It's a good practice to place a nav controller high in our composable hiearchy so we can easily compose down to our composable tree to all our composable screens
*  **Nav Host:** Its purpose is to define a navigation graph. We define all our screens, routes, arguments and everything else we need to setup a navitagion successfully, also we define our start destination as well

## Arguments ##
* **Required Arguments:** Pass a value every time you're navigating to different screens 
* **Optional Arguments:** You don't need to pass that argument every time you are navigating throught other screen, because you need to specify a defult value that will be used whenever you don't pass any value to other screen

## Nested Navigation ##
We can explain this using a graph like this
![Screenshot from 2024-09-27 19-23-19](https://github.com/user-attachments/assets/bf1ab12b-f72a-4b03-a156-ef786aefe883)

With a few destinations, is good to have one root Nav Graph
But this is not always the case
![Screenshot from 2024-09-27 19-25-52](https://github.com/user-attachments/assets/ba442197-f875-485e-86ab-6fc6211a0fd1)

All routes will be in a single file or Nav Graph
So, when the project has many screens (20-30) we should implement a nested navigation graph
![image](https://github.com/user-attachments/assets/98ce0f85-9ab7-456b-b55d-de06b7dd052f)

We could improve this even further
![image](https://github.com/user-attachments/assets/5942e920-bed1-4e49-a140-9c5261f6cafe)

## WHEN TO CREATE NEW NAV HOSTS? ##
![image](https://github.com/user-attachments/assets/0bf9910a-1f95-4067-b6ed-c98c447b1a03)

In this case, A root graph creates an initial Nav Host Controller associated to a single nav controller, this nav host controller is passed as an argument to  Home and Authentication Nav Graphs, nevertheless, HomeScreen will be the only way we can access to another nav gaph non associated to the other two, so we create a new Nav Host controller associated to its Nav Controller.
Take a look at the root Nav graph which is receiving an NavHostController instance from rememberNavController() method of the main actvity
![image](https://github.com/user-attachments/assets/8d5a3f46-b203-4040-8753-164877a579b8)
As you can see, HomeScreen() is not reveiving the NavHostController, because it will eventually create its own NavHostController
![image](https://github.com/user-attachments/assets/ef538128-7209-420f-9019-22c1dd0b52ec)


