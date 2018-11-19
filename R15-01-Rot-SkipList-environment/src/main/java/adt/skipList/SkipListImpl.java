package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve conectar
	 * todos os forward. Senao o ROOT eh inicializado com level=1 e o metodo deve
	 * conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	@Override
	public void insert(int key, T newValue, int height) {
		SkipListNode<T> x = root.getForward(maxHeight);
		for (int i = maxHeight; i > 0; i--) {
			while (x.forward[i].key < key) {
				x = x.forward[i];
			}
		}
		x = x.forward[1];

		if (x.key == key) {
			x.setValue(newValue);
		} else {

		}

		SkipListNode<T> newNode = new SkipListNode<T>(key, height, newValue);

	}

	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> x = root.getForward(maxHeight);
		for (int i = maxHeight; i > 0; i--) {
			while (x.forward[i].key < key) {
				x = x.forward[i];
			}
		}
		// pega o proximo do x, pois ele sempre vai chegar no 1
		x = x.getForward(1);
		SkipListNode<T> toReturn = null;
		if (x.getKey() == key) {
			toReturn = x;
		}
		return toReturn;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SkipListNode<T>[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}