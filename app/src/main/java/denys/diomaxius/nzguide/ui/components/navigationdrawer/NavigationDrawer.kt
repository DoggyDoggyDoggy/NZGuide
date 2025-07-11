package denys.diomaxius.nzguide.ui.components.navigationdrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        },
        content = content,
    )
}

@Composable
fun DrawerContent(modifier: Modifier = Modifier) {
    ModalDrawerSheet(
        modifier = modifier.width(200.dp)
    ) {
        Column {
            NavigationDrawerItem(
                label = { Text("First Item") },
                selected = false,
                onClick = { }
            )
            NavigationDrawerItem(
                label = { Text("Second Item") },
                selected = false,
                onClick = { }
            )
        }
    }
}