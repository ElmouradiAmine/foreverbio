import React, {Component} from 'react';
import {Card, Form, Button, Col} from 'react-bootstrap';
import axios from 'axios';
import {faSave,faUndo, faList} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import Modal from 'react-bootstrap/Modal'

export default class Category extends Component{
    constructor(props){     super(props);
                            this.state = this.initialState;
                            this.categoryChange = this.categoryChange.bind(this);
                            this.submitCategory = this.submitCategory.bind(this);
                            this.exist = null;   }

    initialState = {id: null , nom:'', image: '', description: ''};

    componentDidMount(){    const categoryId = +this.props.match.params.id;
                            if(categoryId){ this.findCategoryById(categoryId); }  };

    findCategoryById = (categoryId) =>
     {      axios.get("http://localhost:8080/Category/" + categoryId)
                 .then(response => {
                      if(response.data != null){
                              this.setState({
                              id: response.data.id,
                              nom: response.data.nom,
                              image: response.data.image,
                              description: response.data.description }); }  });
     }

    categoryChange = event => {      this.setState({[event.target.name]: event.target.value});   }

    updateCategory = event =>{ const category ={ id: this.state.id,
                                                 nom: this.state.nom,
                                                 image: this.state.image,
                                                 description: this.state.description  };
                               event.preventDefault();
                               axios({
                                         method: 'put',
                                         url: 'http://localhost:8080/Category/edit/'+ this.state.id,
                                        data: {   id: this.state.id,
                                                  nom: this.state.nom,
                                                  image: this.state.image,
                                                  description: this.state.description}  })
                                    .then( response => {
                                    if(response.data != null){
                                                // this.setState(this.initialState);
                                                //alert("Category Updated Successfully");
                                                setTimeout(() => this.list(), 1000);  }     });  }


    resetCategory = () => {  this.setState(() => this.initialState);    }


    submitCategory = event => {
         /*const category ={
                            id: this.state.id,
                            nom: this.state.nom,
                            image: this.state.image,
                            description: this.state.description*//*
                              };*/
                    event.preventDefault();
                    axios({
                            method: 'post',
                            url: 'http://localhost:8080/Category/add',
                            data: {  id: this.state.id,
                                     nom: this.state.nom,
                                     image: this.state.image,
                                     description: this.state.description}  })
                            .then( response => {
                            if(response.data != null){
                            this.setState(this.initialState);
                            alert("Category Saved Successfully");
                            setTimeout(() => this.list(), 1000);  }  });   };

    list = () => { return this.props.history.push("/all"); }


    render(){
        const {id, nom, image, description} = this.state
        return(   <Modal.Dialog size="lg">
                  <Modal.Header closeButton>
                  <Modal.Title>{this.state.id ? "Modifier Catégorie" : "Ajouter Catégorie" }</Modal.Title>
                  </Modal.Header>
                  <Modal.Body>
                      <Form style={{width: '700px'}} onReset ={this.resetCategory} onSubmit = {this.state.id ? this.updateCategory : this.submitCategory} id="categoryform">
                                            <Form.Group as={Col} controlId="formGridnom">
                                                    <Form.Label>nom</Form.Label>
                                                    <Form.Control required
                                                    type="text" name="nom"
                                                    size="lg"
                                                    value={nom} autoComplete="off"
                                                    onChange={this.categoryChange}
                                                    placeholder="Enter nom" />
                                             </Form.Group>

                                              <Form.Group as={Col} controlId="formGridImage">
                                                    <Form.Label> URL </Form.Label>
                                                    <Form.Control required
                                                     type="text" name="image"
                                                     size="lg"
                                                     value={image} autoComplete="off"
                                                     onChange={this.categoryChange}
                                                     className=" text-black"
                                                     placeholder="Enter URL " />
                                              </Form.Group>

                                              <Form.Group as={Col} controlId="formGridDescription">
                                                    <Form.Label> Description </Form.Label>
                                                    <Form.Control required
                                                    type="text" name="description"
                                                    size="lg"
                                                    value={description} autoComplete="off"
                                                   onChange={this.categoryChange}
                                                   placeholder="Enter Description" />
                                               </Form.Group>

                       <Button size="lg" variant="success" type="submit"><FontAwesomeIcon icon={faSave}/> {this.state.id ? "Modifier" : "Ajouter" } </Button>{'  '}
                       <Button size="lg" variant="info" type="reset"><FontAwesomeIcon icon={faUndo}/> Réinitialiser </Button>{'  '}
                       <Button size="lg" variant="info" type="button" onClick={this.list.bind()}><FontAwesomeIcon icon={faList}/> Revenir à la liste </Button>
                       </Form>
                  </Modal.Body>
                  </Modal.Dialog>  );  }   }