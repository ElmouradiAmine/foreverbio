import React from 'react';
import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';


class NavigationBar extends React.Component {
    render(){
    return(
            <Navbar bg="light" variant="light" expand="xl" style={{width: '150px'}}>
            <Link to ={"/all"} className="navbar-brand">
                    Forever Bio
            </Link>
                <Nav className="mr-auto" fill variant="tabs" >
                       <Link to ={"/add"} className="nav-link" style={{width: '300px'}}>         Ajouter Catégorie </Link>

                 </Nav>
            </Navbar>


    );
    }


}

export default NavigationBar;