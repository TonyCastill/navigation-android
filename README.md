# NAVIGATION #
## CONCEPTS ##
* **Nav Controller:** Keep track of a back stack in a state of composable screens. It's a good practice to place a nav controller high in our composable hiearchy so we can easily compose down to our composable tree to all our composable screens
*  **Nav Host:** Its purpose is to define a navigation graph. We define all our screens, routes, arguments and everything else we need to setup a navitagion successfully, also we define our start destination as well

## Arguments ##
* **Required Arguments:** Pass a value every time you're navigating to different screens 
* **Optional Arguments:** You don't need to pass that argument every time you are navigating throught other screen, because you need to specify a defult value that will be used whenever you don't pass any value to other screen
