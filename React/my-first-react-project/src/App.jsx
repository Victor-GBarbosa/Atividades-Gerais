export default function App() {
  return (
    <div>
      {Comp()} {Comp1()}
    </div>
  );
}
function Comp() {
  return <p>Ola mundo</p>;
}
function Comp1() {
  return <p>Ola mundo2</p>;
}
