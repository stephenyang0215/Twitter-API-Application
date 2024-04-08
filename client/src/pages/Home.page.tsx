import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { Welcome } from '../components/Welcome/Welcome';
import { ColorSchemeToggle } from '../components/ColorSchemeToggle/ColorSchemeToggle';
import TweetCard from '@/components/Card/TweetCard';
import PostCard from '@/components/PostCard';
import mediaImage from '@/0tter.jpg'

export function HomePage() {
  return (
    <AppShell>
    <AppShell.Header Headerheight={100} p="xs" style={{ backgroundColor: '#1DA1F2', color: 'white' }}>
      
    <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
      <Text style={{ color: 'white', fontWeight: 1000 }}>Twitter Fetch</Text>

      </Container>
  </AppShell.Header>
      <Stack
      h={1000}
      bg="var(--mantine-color-body)"
      align="center"
      gap="sm"
    >
      <PostCard />
     
      {/* <Welcome /> */}
      {/* <ColorSchemeToggle /> */}
      <TweetCard
        name="Stephen Yang"
        account="stephenyang0215"
        time="7:03 PM · Mar 6, 2024"
        tweet="Hello World!"
        views= "100"
        imageUrl="mediaImage"
        />
    </Stack>

</AppShell>
  
  
   

  );
}
