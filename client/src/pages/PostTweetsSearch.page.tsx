import SearchBar from '@/components/SearchBar';
import HomeCard from '@/components/HomeCard';
import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { useState} from 'react';


interface Tweet {
    id: string,
    tweets: string;
  }
export function PostTweetsSearchPage() {
    const [data, setData] = useState<Tweet>();

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

    const handleDelete = async (id: string) => {
        const token = localStorage.getItem('accessToken');
  if (!token) {
    console.error('No access token found');
    return;
  }
        const response = await fetch(
          `http://localhost:8080/removeTweetsById?id=${encodeURIComponent(id)}&accessToken=${encodeURIComponent(token)}`,{
        
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
     
      }



    return(
    <AppShell>
        <Container>
            <SearchBar  onSearch={handleSearch}/>
                {data && <HomeCard id={data.id} tweet={data.tweets} onDelete={handleDelete}/>
                }




        <AppShell.Navbar>
                    <Container>
                    <Stack>
                        <a href="/">HomePage</a>
                                                      <a href="/alldata">ALL DATA</a>
                                                      <a href="/searchAll">search Timelines</a>
                                                      <a href="/searchPost">search profile</a>
                                                      <a href="/bookmarks">Bookmarks</a>
                                                      <a href="/me">Profile</a>
                    </Stack>
                    </Container>
                </AppShell.Navbar>
                </Container>
                </AppShell>
    )
    
}