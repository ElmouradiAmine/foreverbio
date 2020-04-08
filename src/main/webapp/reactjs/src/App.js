import React from 'react';
import './App.css';
import NavigationBar from './components/NavigationBar';
import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import CategoryList from './components/CategoryList';
import AddCategory from './components/AddCategory';



function App() {
    const marginLeft = { marginLeft:"20px"  };
  return (
    <Router>
      <NavigationBar/>
      <Container>
      <Row>
            <Col lg={12} style={marginLeft}>
           <Switch>
            <Route path="/all" exact component={CategoryList}/>
            <Route path="/add" exact component={AddCategory}/>
            <Route path="/edit/:id" exact component={AddCategory}/>


           </Switch>
           </Col>
      </Row>
      </Container>
    </Router>
  );
}

export default App;
