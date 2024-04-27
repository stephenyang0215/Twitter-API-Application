import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { Welcome } from '../components/Welcome/Welcome';
import { ColorSchemeToggle } from '../components/ColorSchemeToggle/ColorSchemeToggle';
import LoginButton from '@/components/LoginButton/LoginButton';
import HomeCard from '@/components/HomeCard';
import PostCard from '@/components/PostCard';
import SearchBar from '@/components/SearchBar';
import mediaImage from '@/0tter.jpg'
import { useEffect, useState } from 'react';


interface Tweet {
  id: string,
  tweets: string;
}

export function HomePage() {
  const [data, setData] = useState<Tweet []>([]);

   useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:8080/findAllTweets'); // Replace with your actual API endpoint
      const jsonData = await response.json();
      console.log(jsonData);
      setData(jsonData);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handleDelete = async (id: string) => {
    const response = await fetch(
      `http://localhost:8080/removeTweetsById?id=${encodeURIComponent(id)}&accessToken=${encodeURIComponent("OWVtcHhTTEFIdkFsQ1RLOEFQNjBPRU9ETDJ5SHBkNThwOHRRdGhXZmF5YTByOjE3MTQwNzYzNTU1NTg6MToxOmF0OjE")}`,{
    
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        // Include other headers as required
    },
    
    });
    if (response.ok) {
      console.log('Tweet deleted');
    } else {
      console.error('Failed to delete tweet');
    } 
    const newData = data.filter(item => item.id !== id); //?
    setData(newData);
  }
  
  const handlePost = async (tweetText: string) => {
    const response = await fetch(
      `http://localhost:8080/addTweets?accessToken=${encodeURIComponent("OWVtcHhTTEFIdkFsQ1RLOEFQNjBPRU9ETDJ5SHBkNThwOHRRdGhXZmF5YTByOjE3MTQwNzYzNTU1NTg6MToxOmF0OjE")}&Tweets=${encodeURIComponent(tweetText)}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    });
    if (response.ok) {
      console.log('Tweet posted');
    } else {
      console.error('Failed to post tweet');
    }
  
  }
  const handleSearch = async (searchTerm: string) => {
    try {
        const response = await fetch(`http://localhost:8080/findTweetsById?id=${encodeURIComponent(searchTerm)}`); // Replace with your actual API endpoint
        const jsonData = await response.json();
        console.log(jsonData);
        setData(jsonData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
}

  

  return (
    <AppShell
    header={{ height: 60 }}
    navbar={{
      width: 100,
      breakpoint: 'sm',
      collapsed: { mobile: !open },
    }}
    padding="sm"
    
    >
      
      
    <AppShell.Header p="xs" style={{ backgroundColor: '#1DA1F2', color: 'white' }}>
      
    <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
      <Text style={{ color: 'white', fontWeight: 1000 }}>Twitter Fetch</Text>
      
      </Container>
  </AppShell.Header>
  <AppShell.Navbar>
  <Container>
    <Stack>
      <a href="/">HomePage</a>
      <a href="/bookmarks">Bookmarks</a>
      <a href="/lookup">Look up</a>
      <a href="/recentsearch">Recent search</a>
      <a href="/timeline">Timelines</a>
    </Stack>
    </Container>
  </AppShell.Navbar>
    <AppShell.Main>
    <Stack
      bg="var(--mantine-color-body)"
      align="center"
      gap="sm"
    >
      <PostCard 
        onPost={handlePost}
      />
       <SearchBar  onSearch={handleSearch}/>
        {data && <HomeCard id={data.id} tweet={data.tweets} onDelete={handleSearch}/>
        
        }
                
     
      {/* <Welcome /> */}
      {/* <ColorSchemeToggle /> */}
      
      {data.map((item: Tweet) => {
            // console.log(item.id),
            // console.log(typeof item.id),
            // console.log(item.tweets),
            // console.log(typeof item.tweets),
            return(
              <HomeCard
              key={item.id}
              id={item.id}
              tweet={item.tweets}
              onDelete={handleDelete}
              /> 
            )
              
      })}
          
    
   
    </Stack>
    </AppShell.Main>

</AppShell>
  
  
   

  );
}
