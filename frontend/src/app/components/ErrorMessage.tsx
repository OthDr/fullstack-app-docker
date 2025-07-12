interface Props {
  message: string;
}

export default function ErrorMessage({ message }: Props) {
  return (
    <div className="bg-red-100 text-red-700 px-4 py-2 rounded-xl border border-red-400 text-center">
      {message}
    </div>
  );
}
