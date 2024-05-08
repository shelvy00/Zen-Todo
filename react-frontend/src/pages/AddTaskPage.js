import { useState } from 'react';
import { Form } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import useTasksContext from '../hooks/tasks-context';

const AddTaskPage = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [startdate, setStartDate] = useState(new Date());
  const [duedate, setDueDate] = useState(new Date());

  //const x = useTasksContext();

  const { createTask } = useTasksContext()

  //console.log(x)

  const handleChange = (e) => {
    setName(e.target.value);
   }
 
   const handleSubmit = (e) => {
     e.preventDefault();
     createTask(name,description,startdate,duedate);
     setName("");
     setDescription("");
     setStartDate("");
     setDueDate("");
   }



  return (
    <div>
      <h1>Add Task</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label><h4>Name</h4></Form.Label>
          <Form.Control size="lg" type="text" placeholder="" as="input" value={name} onChange={handleChange} />
        </Form.Group>
        <br />  
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label><h4>Description</h4></Form.Label>
        <Form.Control as="textarea" rows={3} as="input" value={description} onChange={ (e) => setDescription(e.target.value)} />
      </Form.Group>
        <br />
        <Form.Group>
          <Form.Label><h4>Start Date</h4></Form.Label>
            <Form.Control size="lg" type="date"as="input" value={startdate} onChange={ (e) => setStartDate(e.target.value)}></Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label><h4>Due Date</h4></Form.Label>
            <Form.Control size="lg" type="date" as="input" value={duedate} onChange={ (e) => setDueDate(e.target.value)}></Form.Control>
        </Form.Group>
        <br />
        <Button type="submit" variant="outline-secondary" id="button-addon1" >
          Button
        </Button>
      </Form>
    </div>
  )
}

export default AddTaskPage
