import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { Welcome } from '../components/Welcome/Welcome';
import { ColorSchemeToggle } from '../components/ColorSchemeToggle/ColorSchemeToggle';
import LoginButton from '@/components/LoginButton/LoginButton';
import TweetCard from '@/components/Card/TweetCard';
import PostCard from '@/components/PostCard';
import mediaImage from '@/0tter.jpg'
import { useEffect, useState } from 'react';
export function HomePage() {
  const [data, setData] = useState([]);

  

  return (
    <AppShell
    header={{ height: 60 }}
    navbar={{
      width: 300,
      breakpoint: 'sm',
      collapsed: { mobile: !open },
    }}
    padding="md"
    
    >
      
      
    <AppShell.Header Headerheight={100} p="xs" style={{ backgroundColor: '#1DA1F2', color: 'white' }}>
      
    <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
      <Text style={{ color: 'white', fontWeight: 1000 }}>Twitter Fetch</Text>
      <LoginButton/>
      </Container>
  </AppShell.Header>
  <AppShell.Navbar>
  <Container>
    <Stack>
      <a href="/bookmarks">Bookmarks</a>
      <a href="/lookup">Look up</a>
      <a href="/recentsearch">Recent search</a>
      <a href="/timeline">Timelines</a>
    </Stack>
    </Container>
  </AppShell.Navbar>
    <AppShell.Main>
    <Stack
      h={1000}
      bg="var(--mantine-color-body)"
      align="center"
      gap="sm"
    >
      <PostCard />
   
    </Stack>
    </AppShell.Main>

</AppShell>
  
  
   

  );
}
