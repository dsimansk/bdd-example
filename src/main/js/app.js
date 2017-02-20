'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
const CameleerCards = require('./cameleers/cameleers')

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {cameleers: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/cameleers'}).then(response => {
			this.setState({cameleers: response.entity._embedded.cameleers});
		});
	}

	render() {
		return (
			<CameleerCards cameleers={this.state.cameleers}/>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('cameleers')
)