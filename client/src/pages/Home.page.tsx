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

  // useEffect(() => {
  //   fetch('') // replace with your actual endpoint
  //     .then(response => response.json())
  //     .then(data => setData(data))
  //     .then(data => console.log(data)
  //  }, []);

  //  useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await fetch('http://localhost:8080/findAllTimelines'); // Replace with your actual API endpoint
  //       const jsonData = await response.json();
  //       console.log(jsonData);
  //       setData(jsonData);
  //     } catch (error) {
  //       console.error('Error fetching data:', error);
  //     }
  //   };
  //   fetchData();
  // }, []);

  

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
    <Stack>
      <a href="/bookmarks">Bookmarks</a>
      <a href="/lookup">look up</a>
      <a href="/recentsearch">recent search</a>
      <a href="/timeline">Timelines</a>
    </Stack>
  </AppShell.Navbar>
    <AppShell.Main>
    <Stack
      h={1000}
      bg="var(--mantine-color-body)"
      align="center"
      gap="sm"
    >
      <PostCard />
     
      {/* <Welcome /> */}
      {/* <ColorSchemeToggle /> */}
      
        {/* {data.map((tweet) => (
          <TweetCard
            key={tweet.id}
            name={tweet.name}
            username={tweet.username}
            content={tweet.content}
            avatar={tweet.avatar}
            image={tweet.image}
          />
        ))} */}
   
    </Stack>
    </AppShell.Main>

</AppShell>
  
  
   

  );
}
