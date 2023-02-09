package ir.ahe.abbas.newstest.main

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
 fun BottomNavigation(
    itemList: List<BottomNavItem>,
    navController: NavController
) {

    androidx.compose.material.BottomNavigation {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        itemList.forEach { item ->

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.drawableRes),
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = item.label)) },
                selected = currentDestination?.hierarchy?.any
                { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}