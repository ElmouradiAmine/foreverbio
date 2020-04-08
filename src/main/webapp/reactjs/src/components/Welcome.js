
import React, {Component} from 'react';
import {Card, Table, Button,ButtonGroup, CardColumns, Modal} from 'react-bootstrap';
import {faEdit,faTrash} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import axios from 'axios';
import {Link} from 'react-router-dom';



class Welcome extends React.Component{

constructor(props){
             super(props);
             this.state = {
                      categories : []
                     };
                      }

    componentDidMount(){
        axios.get("http://localhost:8080/Category/all")
             .then(response => response.data)
             .then((data) => {
                          this.setState({categories: data});
                          });

        };

     deleteCategory = (categoryId) =>
     {
        axios.delete("http://localhost:8080/Category/delete/"+ categoryId)
              .then(response => {
              if(response.data != null){
               alert("Category deleted successfully");
               this.setState({
               categories: this.state.categories.filter(category => category.id !== categoryId)
               });

              }
                });
     };



render(){
            console.log(this.state.categories)
             return(<>

                        <Button variant="primary" onClick={handleShow}>
                          Launch demo modal
                        </Button>

                        <Modal show={show} onHide={handleClose}>
                          <Modal.Header closeButton>
                            <Modal.Title>Modal heading</Modal.Title>
                          </Modal.Header>
                          <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
                          <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                              Close
                            </Button>
                            <Button variant="primary" onClick={handleClose}>
                              Save Changes
                            </Button>
                          </Modal.Footer>
                        </Modal>

                <CardColumns style={{ width: '100rem',marginLeft: '-190px',marginTop: '50px'}} >
                     {this.state.categories.map(cat => {
                                           //console.log(cat);
                            return (
                                    <Card style={{ width: '25rem'}} >
                                    <Card.Img variant="top" src={cat.image}/>
                                    <Card.Body>
                                     <Card.Title>{cat.nom}</Card.Title>
                                        <Card.Text>
                                           {cat.description}
                                        </Card.Text>
                                               {'   '}  <ButtonGroup>
                                                   <Link to ={"edit/"+cat.id} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit} style={{width:'80px'}}/></Link>
                                                   <Button style={{width: '90px'}} variant="outline-danger" onClick={this.deleteCategory.bind(this, cat.id)}><FontAwesomeIcon icon={faTrash}/></Button>
                                                 </ButtonGroup>
                                     </Card.Body>
                                     </Card>
                                    )  })}




                </CardColumns>
                </>
                );
 }

}

export default Welcome;