import { Card, Input, TextInput, Group, Button, Grid, Flex} from '@mantine/core';
import {useState, useEffect} from 'react';
import { buildErrorMessage } from 'vite';

interface SearchBarProps{
    onSearch: (searchTerm: string) => void;
    
}

const SearchBar : React.FC<SearchBarProps>= ({onSearch}) => {
  const [searchTerm, setSearchTerm] = useState('');

const handleClickSearch = async () => {
  onSearch(searchTerm);
};
  return (
    <Card p="sm" radius='sm' mt={'10%'} withBorder style={{ width: '80%', height:'flex'}}>
    <Grid align='center'>
    
    <Input 
    placeholder="search here by Id"
    radius={'sm'}
    onChange={(event) => setSearchTerm(event.currentTarget.value)} 
    />
    <Grid.Col span={3} offset={1}>
    <Button  
        color='blue' 
        radius='xl' 
        style={{ alignSelf: 'flex-end' }}
        onClick={handleClickSearch}
        bg='blue'
        >search</Button>
    </Grid.Col>
    </Grid>
    </Card>
  );
};

export default SearchBar;
