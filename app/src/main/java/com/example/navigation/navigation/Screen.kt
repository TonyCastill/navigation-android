package com.example.navigation.navigation


/**
 * We create the sealed class to define routes to our screens
 *
 * Inside the Screen constructor, we pass one variable of a
 * type of a string
 *
 * Everything here can be easily be called from anywhere else,
 * so we can create constants to set arguments
 *
 * We use the constants at the routes and at NavGraph HostController
 * Destination (in this case) composable function
 */

// This just states the name of the argument
const val DETAIL_ARGUMENT_KEY = "id"

//Another argument
const val DETAIL_ARGUMENT_KEY2="name"

//Constants of Nested Navigation Graph
const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"

sealed class Screen(val route : String) {
    //This class contains the screens
    //Here we also can define arguments
    object Home: Screen(route = "home_screen") //Will inherit from the Screen sealed class

    //Work with required arguments
    /**
     * REQUIRED SINGLE ARGUMENT
     * We use brackets {} to define arguments
     * Within this brackets we specify a key name
     * of the argument, id in this case
     * route = "detail_screen/{id}"
     */
    /*object Detail: Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}"){
        // Here we create the functions to call different route/argument combinations
//        fun passId(id: Int): String{
//            //return "detail_screen/$id"
//            // We call the function by route = Screen.Detail.passId(5)
//
//            // We can improve this more
//            // Replace the {$DETAIL_ARGUMENT_KEY} and just call the attribute route
//            return this.route.replace(oldValue="{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
//        }
        fun passNameAndId(
            id: Int,
            name: String
        ): String{
            // Hardcode the route
            return "detail_screen/$id/$name"
        }
    }*/

    // Work with optional arguments
    /**
     * OPTIONAL ARGUMENT
     * We use ? to define optional arguments
     * followed by the key name and the key value
     *
     * Use & to separate different arguments
     */
    object Detail: Screen(route = "detail_screen?id={$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}"){
        fun passId(id: Int= 0):String{ // =0 is the default value
            //Hard coded
            return "detail_screen?id=$id"
        }

        fun passIdAndName(id:Int = 0, name:String="nobody"):String{
            return this.route
                .replace(oldValue ="{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
                .replace(oldValue ="{$DETAIL_ARGUMENT_KEY2}", newValue = name )
        }

    }

    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "sign_up_screen")

}