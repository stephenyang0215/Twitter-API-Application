import {Avatar, Card, Stack,SimpleGrid, Container, Image, Text, Group, Button, useMantineTheme, Flex, rgba } from '@mantine/core';

type TweetCardProps = {
  name: string;
  account: string;
  time: Date;
  tweet: string;
  url: string;
  hashtag: string[];
  views: number;
  imageUrl: string;
};

const TweetCard = ({name, account, time, tweet, views, imageUrl }: TweetCardProps) => {
  const theme = useMantineTheme();

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
            src={"https://images.unsplash.com/photo-1597357821540-3dc1852ef417?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8b3R0ZXJ8ZW58MHx8MHx8fDA%3D"} 
            alt="lool"  
            size={'lg'}
            />
          <SimpleGrid
          cols={1}
          verticalSpacing={'0.1'}
         >
            
            <Text weight={500} >{name}</Text>
            

            <Text  color={theme.colorScheme === 'dark' ? 'dark' : 'dimmed'}>{account}</Text>
          </SimpleGrid>
        </Group>
        <Text>{tweet}</Text>
        <Group 
        justify='flex-start'
        gap={'1'}
        >
        <Text size="sm" color={theme.colorScheme === 'dark' ? 'dark' : 'dimmed'}>
          {time}
        </Text>
        <Text size='sm' color={theme.colorScheme === 'dark' ? 'dark' : 'dimmed'}>·{views}Views</Text>
        </Group>
       
        
        <Button variant="light" color="blue" fullWidth>
          share this tweet
        </Button>
      </Stack>
    </Card>
  );
};

export default TweetCard;
