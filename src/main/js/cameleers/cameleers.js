'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const pluralize = require('pluralize');

class CameleerCards extends React.Component {
	render() {
		const cameleers = this.props.cameleers.map(cameleer =>
			<Cameleer key={cameleer._links.self.href} cameleer={cameleer}/>
		);
		return (
			<div className="ui link cards">
				{cameleers}
				<div className="ui card">
					<div className="image">
						<img src="/cameleer.png" />
					</div>
					<div className="content">
						<div className="header">Add a cameleer...</div>
					</div>
				</div>
			</div>
		)
	}
}

class Cameleer extends React.Component {
	constructor(props) {
		super(props);

		this.state = props.cameleer;

		this.showCamels = this.showCamels.bind(this);
		this.addCamel = this.addCamel.bind(this);
	}

	showCamels() {
		$(this.modal).modal('show');
	}

	addCamel() {
		if (this.name.value) {
			this.setState({
				camels: this.state.camels.concat([{
					name: this.name.value,
					description: this.description.value
				}])
			})
		}
	}

	componentDidMount() {
		$(this.modal).modal({
			blurring: true,
			transition: 'drop'
		});
	}

	render() {
		const avatarUrl = `https://api.adorable.io/avatars/285/${this.state.name}.png`
		const camels = this.state.camels.map(camel => 
			<Camel key={camel.name} camel={camel}/>
		);
		return (
			<div>
				<div className="ui card" onClick={this.showCamels}>
					<div className="image">
						<img src={avatarUrl} />
					</div>
					<div className="content">
						<div className="header">{this.state.name}</div>
						<CameleerSummary camels={this.state.camels} />
					</div>
				</div>
				<div className="ui modal" ref={(input) => { this.modal = input; }}>
					<i className="close icon"></i>
					<div className="header">{this.state.name}'s great herd</div>
					<div className="content">
						<div className="ui divided items">
							{camels}
						</div>
						<div className="ui horizontal divider">
							Add a camel
						</div>
						<div className="ui form">
							<div className="field">
								<label>Camel name</label>
								<input ref={(input) => { this.name = input; }} name="name" type="text"/>
							</div>
							<div className="field">
								<label>Description</label>
								<textarea ref={(input) => { this.description = input; }} name="description" rows="2"></textarea>
							</div>
							<button onClick={this.addCamel} className="ui teal add button"><i className="plus icon"></i> Add</button>
						</div>
					</div>
					<div className="actions">
						<div className="ui black deny close button"><i className="close icon"></i> Close</div>
					</div>
				</div>
			</div>
		)
	}
}

class CameleerSummary extends React.Component {
	render() {
		const count = (this.props.camels || []).length;
		const info = pluralize("Camel", count);
		return (
			<div className="extra content">
				<span> <i className="user paw icon"></i> <span className="count">{count}</span> {info}</span>
			</div>
		)
	}
}

class Camel extends React.Component {
	render() {
		return(
			<div className="item">
				<div className="content">
					<a className="header">{this.props.camel.name}</a>
					<div className="description">
						<p>{this.props.camel.description}</p>
					</div>
				</div>
			</div>
		)
	}
}

module.exports = CameleerCards