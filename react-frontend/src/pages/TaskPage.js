import React from 'react'
import { Table, Button } from 'react-bootstrap'

const TaskPage = () => {
  return (
    <Table striped bordered hover size="lg" >
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Description</th>
          <th>Start Date</th>
          <th>Due Date</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>5-1-24</td>
          <td>5-3-24</td>
          <td>
            <Button href="/add-tasks" variant="success" >Edit</Button>{' '}
            <Button href="/" variant="danger" >Delete</Button>{' '}
          </td>  
        </tr>
        <tr>
          <td>2</td>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>5-1-24</td>
          <td>5-3-24</td>
        </tr>
        <tr>
          <td>3</td>
          <td colSpan={2}>Larry the Bird</td>
          <td>5-1-24</td>
          <td>5-3-24</td>
        </tr>
      </tbody>
    </Table>
  )
}

export default TaskPage
