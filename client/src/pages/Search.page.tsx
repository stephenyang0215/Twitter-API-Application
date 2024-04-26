import SearchBar from '@/components/SearchBar';
import HomeCard from '@/components/HomeCard';
import { Container } from '@mantine/core';
import { useState} from 'react';
import { identity } from '@mantine/core/lib/core/factory/factory';

interface Tweet {
    id: string,
    tweets: string;
  }
export function SearchPage() {
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
    


    return(
        <Container>
            <SearchBar  onSearch={handleSearch}/>
                {data && <HomeCard id={data.id} tweet={data.tweets}/>
                }
                
           

        </Container>
    )
    
}