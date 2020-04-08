import React, {Component} from 'react';
import {Card, Table, Button,ButtonGroup, CardColumns, CardGroup, CardDeck} from 'react-bootstrap';
import {faEdit,faTrash} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import axios from 'axios';
import {Link} from 'react-router-dom';
import Modal from 'react-bootstrap/Modal';


export default class CategoryList extends Component{

    constructor(props){     super(props);
                            this.state = {
                            categories : [], show : false };    }

    componentDidMount(){
                            axios.get("http://localhost:8080/Category/all")
                            .then(response => response.data)
                            .then((data) => {
                            this.setState({categories: data});   });         };

     deleteCategory = (categoryId) =>
     {        axios.delete("http://localhost:8080/Category/delete/"+ categoryId)
              .then(response => {
              if(response.data != null){
              this.setState({
              categories: this.state.categories.filter(category => category.id !== categoryId)
               });  }  });
              this.handleModal();       }

     handleModal()
     {      this.setState({show: !this.state.show}) }


     render(){
              console.log(this.state.categories)
              return(
              <>

              <CardColumns style={{ width: '105rem',marginLeft: '-330px',marginTop: '50px',display: 'flex', flexDirection: 'row'}} >
              {this.state.categories.map(cat => {
                  //console.log(cat);
                   return (
                             <Card style={{ width: '75%', height: '40rem', flex: 1}} >
                             <Card.Img variant="top" src={cat.image} style={{ width: '100%', height: '20rem'}}/>
                             <Card.Body>
                                <Card.Title>{cat.nom}</Card.Title>
                                <Card.Text> {cat.description} </Card.Text>
                       {'   '}   <ButtonGroup>
                                        <Link to ={"edit/"+cat.id} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit} style={{width:'80px'}}/></Link>
                                        <div>
                                        <Button style={{width: '90px'}} variant="outline-danger" onClick={()=> {this.handleModal()}}><FontAwesomeIcon icon={faTrash} style={{width:'80px'}}/></Button>
                                        <Modal show={this.state.show} centered animation={true} autoFocus={false} style={{ background: 'transparent'}}>
                                        <Modal.Header> Supprimer la categorie </Modal.Header>
                                        <Modal.Body> Êtes-vous sûr de vouloir supprimer cette categorie ? </Modal.Body>
                                        <Modal.Footer>
                                                <ButtonGroup>
                                                     <Button variant="danger" size="lg" style={{width: '90px'}} onClick={this.deleteCategory.bind(this, cat.id)}>  Oui  </Button>
                                                     <Button size="lg" style={{width: '100px'}} onClick={()=> {this.handleModal()}}>    Annuler     </Button>
                                                </ButtonGroup>
                                        </Modal.Footer>
                                        </Modal>

                                        </div>

                                  </ButtonGroup>
                              </Card.Body>
                              </Card>
                                  )  })}

              </CardColumns>
              </>  ); }  }

