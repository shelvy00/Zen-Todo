import React, { useState } from 'react'
import { Form } from 'react-bootstrap'
import Button from 'react-bootstrap/Button';

const AddTaskPage = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [startdate, setStartDate] = useState("");
  const [duedate, setDueDate] = useState("");



  return (
    <div>
      <h1>Add Task</h1>
      <Form>
        <Form.Group>
          <Form.Label><h4>Name</h4></Form.Label>
          <Form.Control size="lg" type="text" placeholder="" />
        </Form.Group>
        <br />  
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label><h4>Description</h4></Form.Label>
        <Form.Control as="textarea" rows={3} />
      </Form.Group>
        <br />
        <Form.Group>
          <Form.Label><h4>Start Date</h4></Form.Label>
            <Form.Control size="lg" type="date" ></Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label><h4>Due Date</h4></Form.Label>
            <Form.Control size="lg" type="date" ></Form.Control>
        </Form.Group>
        <br />
        <Button variant="outline-secondary" id="button-addon1">
          Button
        </Button>
      </Form>
    </div>
  )
}

export default AddTaskPage
