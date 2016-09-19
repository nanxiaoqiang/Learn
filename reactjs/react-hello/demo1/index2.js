var MyCompnent = React.createClass({
  handleClickX: function() {// 函数名称可以随意更改，下边的调用对上就行
    var inputTextById = $('#textInputId').val();
    console.log(inputTextById);// 可以输出
    var inputTextByRef = this.refs.myTextInput.value;
    console.log(inputTextByRef);// 可以输出
  },
  render: function() {
    return (
      <div>
        <input type="text" ref="myTextInput" id="textInputId" />
        <input type="button" value="Click Me!" onClick={this.handleClickX}/>
      </div>
    );
  }
});

ReactDOM.render(
  <MyCompnent />,
  document.getElementById('content')
);

var MyCompnentLike = React.createClass({
  getInitialState: function() {// 初始化属性，使用this.state调用的内部属性是可以改变的，this.props貌似不行
    return {like: false};
  },
  handleClick: function(event) {
    console.log('now like state is: ' + this.state.like + ' and change to: ' + !this.state.like);
    this.setState({like: !this.state.like});
  },
  render: function() {
    var likeText = this.state.like ? '喜欢，顶！' : '不喜欢，踩！';
    return (
      <div>
        <p onClick={this.handleClick} >点击更改结果: {likeText}</p>
      </div>
    );
  }
});

ReactDOM.render(
  <MyCompnentLike />,
  // $('#content1') // 不能这样写啊……
  document.getElementById('content1')
);

// var MyComponentForm = React.createClass({
//   getInitialState: function() {// 默认初始化
//     return {author: '', text: ''};
//   },
//   handleAuthorChange: function(e) {
//     this.setState(e.target.value);
//   },
//
// });
