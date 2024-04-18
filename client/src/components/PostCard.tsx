import { Avatar, Card, Container, Text,Textarea, Group, Button, useMantineTheme, Grid, Stack, Flex} from '@mantine/core';

type TweetCardProps = {
  
};

const PostCard = () => {
  const theme = useMantineTheme();

  return (
    <Card p="sm" radius='sm' mt={'10%'} withBorder style={{ width: '80%', height:'flex'}}>
      
      <Group align='flex-start'>
        <Avatar color='cyan' size={'md'} radius='xl'>SY</Avatar>
        <Textarea placeholder="What's happening?" style={{flexGrow:3}} />
      </Group>
      <Group mt='sm' justify='flex-end'>
        <Button  color='blue' radius='xl' style={{ alignSelf: 'flex-end' }}>Tweet !</Button>
      </Group>  
    
    </Card>
  );
};

export default PostCard;
