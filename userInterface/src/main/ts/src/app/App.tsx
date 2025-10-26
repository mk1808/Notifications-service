import './App.sass'
import { Button, Field, HStack, Input, RatingGroup, Slider } from '@chakra-ui/react'

function App() {

  return (
    <>
      <HStack>
        <Button onClick={() => console.log()}>Click me</Button>
        <Button>Click me</Button>
        <Field.Root>
          <Field.Label>Email</Field.Label>
          <Input placeholder="me@example.com" />
        </Field.Root>
        <Slider.Root width="200px" defaultValue={[40]}>
      <Slider.Control>
        <Slider.Track>
          <Slider.Range />
        </Slider.Track>
        <Slider.Thumbs />
      </Slider.Control>
    </Slider.Root>
    <RatingGroup.Root count={5} defaultValue={3} size="sm">
      <RatingGroup.HiddenInput />
      <RatingGroup.Control />
    </RatingGroup.Root>
      </HStack>
    </>
  )
}

export default App
