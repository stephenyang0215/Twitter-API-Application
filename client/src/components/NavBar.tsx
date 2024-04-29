import { Container, Stack } from "@mantine/core"
export function NavBar(){
    return(
        <Container>
    <Stack>
      <a href="/">HomePage</a>
      <a href="/bookmarks">Bookmarks</a>
      <a href="/lookup">Look up</a>
      <a href="/recentsearch">Recent search</a>
      <a href="/timeline">Timelines</a>
      <a href="/allData">All Data temp</a>
    </Stack>
    </Container>
    )
}