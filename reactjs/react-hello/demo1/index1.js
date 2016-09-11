var CommentBoxOld = React.createClass({
  render: function() {
    return (
      <div className="commentBoxOld">
        Hello World! I'm a CommentBoxOld.
      </div>
    );
  }
});

ReactDOM.render(
  <CommentBoxOld/>,
  document.getElementById('content')
);

var CommentBoxOld1 = React.createClass({
  render: function() {
    return (
      <div className="commentBoxOld1">
        Hello {this.props.name}! I'm a CommentBoxOld1.
      </div>
    );
  }
});

ReactDOM.render(
  <CommentBoxOld1 name="nanxiaoqiang"/>,
  document.getElementById('content1')
);

var NodeList = React.createClass({
  render: function() {
    return (
      <ol>{
        React.Children.map(this.props.children, function(child) {
          return <li>{child}</li>
        })
      }</ol>
    );
  }
});

ReactDOM.render(
  <NodeList>
    <span>南肖墙</span>
    <span>nanxiaoqiang</span>
  </NodeList>,
  document.getElementById('content2')
);

var CommentBoxOld2 = React.createClass({
  // 设置默认值
  getDefaultProps: function() {
    return {
      title: 'DefaultTitle'
    };
  },
  propTypes: {
    name: React.PropTypes.string.isRequired
  },
  render: function() {
    return (
      // 因为class是js关键字，所以class写为className，同理for写为htmlFor
      <div className="commentBoxOld2">
        {this.props.title}:Hello {this.props.name}! I'm a CommentBoxOld1.
      </div>
    );
  }
});
// var errorNameNumber = 123;
ReactDOM.render(
  // 此处因为用了数字类型，所以会报错：Warning: Failed prop type: Invalid prop `name` of type `number` supplied to `CommentBoxOld2`
  // <CommentBoxOld2 name={errorNameNumber}/>,
  <CommentBoxOld2 name="nanxiaoqiang" title={void 0}/>,
  document.getElementById('content3')
);
