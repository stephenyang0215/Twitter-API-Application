import { Container, Stack } from "@mantine/core"
export function NavBar(){
    return(
        <Container>
    <Stack>
      <a href="/">HomePage</a>
      <a href="/alldata">ALL Post</a>
      <a href="/searchAll">Search Timelines</a>
      <a href="/searchPost">Search Post</a>
      <a href="/bookmarks">Bookmarks</a>
      <a href="/me">Profile</a>
    </Stack>
    </Container>
    )
}