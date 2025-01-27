import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import chat.simplex.app.ui.theme.GroupDark
import chat.simplex.app.ui.theme.HighOrLowlight

@Composable
fun SectionView(title: String? = null, content: (@Composable () -> Unit)) {
  Column {
    if (title != null) {
      Text(
        title, color = HighOrLowlight, style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(start = 16.dp, bottom = 5.dp), fontSize = 12.sp
      )
    }
    Surface(color = if (isSystemInDarkTheme()) GroupDark else MaterialTheme.colors.background) {
      Column(Modifier.padding(horizontal = 6.dp).fillMaxWidth()) { content() }
    }
  }
}

@Composable
fun SectionItemView(click: (() -> Unit)? = null, height: Dp = 46.dp, disabled: Boolean = false, content: (@Composable () -> Unit)) {
  val modifier = Modifier
    .padding(horizontal = 8.dp)
    .fillMaxWidth()
    .height(height)
  Row(
    if (click == null || disabled) modifier else modifier.clickable(onClick = click),
    verticalAlignment = Alignment.CenterVertically
  ) {
    content()
  }
}

@Composable
fun SectionTextFooter(text: String) {
  Text(
    text,
    Modifier.padding(horizontal = 16.dp).padding(top = 5.dp).fillMaxWidth(0.9F),
    color = HighOrLowlight,
    fontSize = 12.sp
  )
}

@Composable
fun SectionCustomFooter(content: (@Composable () -> Unit)) {
  Row(
    Modifier.padding(horizontal = 16.dp).padding(top = 5.dp)
  ) {
    content()
  }
}

@Composable
fun SectionDivider() {
  Divider(Modifier.padding(horizontal = 8.dp))
}

@Composable
fun SectionSpacer() {
  Spacer(Modifier.height(30.dp))
}

@Composable
fun InfoRow(title: String, value: String) {
  SectionItemView {
    Row(
      Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(title)
      Text(value, color = HighOrLowlight)
    }
  }
}
