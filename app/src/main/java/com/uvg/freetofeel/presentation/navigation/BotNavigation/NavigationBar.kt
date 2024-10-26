package com.uvg.freetofeel.presentation.navigation.BotNavigation

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource

@Composable
fun NavigationBar (
    checkItemSelected: (Any) -> Boolean,
    onNavItemClick: (Any) -> Unit
){
    NavigationBar {
        menuItemsBotNav.forEach{ itemNav ->
            val isSelected = checkItemSelected(itemNav.destination)
            NavigationBarItem(
                selected = isSelected,
                label = { Text(itemNav.title) },
                onClick = { onNavItemClick(itemNav.destination)},
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) {
                                itemNav.selectedIcon
                            } else {
                                itemNav.unselectedIcon
                            }

                        ),
                        contentDescription = itemNav.title
                    )
                }
            )

        }
    }
}
