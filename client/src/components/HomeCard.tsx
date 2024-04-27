import {Avatar, Card, Stack,SimpleGrid, Container, Image, Text, Group, Button, useMantineTheme, Flex, rgba } from '@mantine/core';
import {useState} from 'react';
type HomeCardProps = {
  id:string,
  tweet: string;
  onDelete: (id: string) => void;
};

const HomeCard: React.FC<HomeCardProps> = ({id, tweet, onDelete}) => {


  const handleClickDelete = async () => {
    onDelete(id)
    
  }

  return (
    <Card shadow="sm" p="lg" radius="md" withBorder style={{ width: '80%', height:'flex'}}>
      <Stack
     
      >
        <Group
        
        justify='flex-start'
        gap={'xs'}
        >
          
          {/* <Image 
          src={"https://images.unsplash.com/photo-1597357821540-3dc1852ef417?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8b3R0ZXJ8ZW58MHx8MHx8fDA%3D"} 
            alt="lool" 
            h={50}
            w={50}
            style={{borderRadius: '50%'}}
            fit='fill' />      */}
            <Avatar
            color='cyan'
            alt="lool"  
            size={'lg'}
            >
              HC
            </Avatar>  
          <SimpleGrid
          cols={1}
          verticalSpacing={'0.1'}
         >
            
            <Text>Home card</Text>
            

            <Text >@ Home card</Text>
          </SimpleGrid>
        </Group>
        <Text>{tweet}</Text>
        <Group 
        justify='flex-start'
        gap={'1'}
        >
        <Text size="sm" >
          example time(fixed)
        </Text>
        <Text size='sm' >·1 Views(fixed)</Text>
        <Text>{id}</Text>
        </Group>
       
        
        <Button variant="light" color="blue" fullWidth>
            share this tweet
        </Button>
        <Button 
        variant="light" 
        color='red'
        onClick={handleClickDelete}
        >
            Delete this tweet
        </Button>
      </Stack>
    </Card>
  )
};


export default HomeCard;
