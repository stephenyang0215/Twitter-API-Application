import {Avatar, Card, Stack,SimpleGrid, Container, Image, Text, Group, Button, useMantineTheme, Flex, rgba } from '@mantine/core';

type TweetCardProps = {
  
  account: string;
  tweet: string;
  url: string;
  hashtag: string[];
  search: string[];
  share_tweet: {};
  share_url: string;
  time: string;
  views: number;
  

};

const TweetCard = ({account,tweet,url, hashtag, search, share_tweet, share_url, time, views }: TweetCardProps) => {
  const theme = useMantineTheme();

  return (
    <Card shadow="sm" p="lg" radius="md" withBorder style={{ width: '80%', height:'flex'}}>
      <Stack
      >
        <Group   
        justify='flex-start'
        gap={'xs'}
        >
            <Avatar
            alt="user avatar"  
            size={'lg'}
            >{account.slice(1,3)}</Avatar>
            <Text size='xl' fw={700} >{account}</Text>

        </Group>
        <Text>{tweet}</Text>
        <Group 
        justify='flex-start'
        gap={'1'}
        >
        <Text size="sm">
          {time}
        </Text>
        <Text size='sm'>·{views}Views</Text>
        </Group>
       
        
        <Button variant="light" color="blue" fullWidth >
          share this tweet
        </Button>
      </Stack>
    </Card>
  );
};

export default TweetCard;
