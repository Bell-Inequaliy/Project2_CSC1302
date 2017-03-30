package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;
import edu.gsu.csc1302.coll1.InsufficientCardsException;

/**
 * Implementation of the Deck class provided.
 * @author J-Dierberger
 */
public class DeckImplementation extends ArrayList<Card> implements Deck {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -7438420584924095038L;

	/**
	 * Create a super.
	 */
	public DeckImplementation() {
	}

	/**
	 * Create a deck with the given contents.
	 * @param deck The contents to initialize with.
	 */
	public DeckImplementation(final Deck deck) {
		super.addAll(deck);
	}

	/**
	 * Create a deck with the given contents.
	 * @param cardList The contents to initialize with.
	 */
	public DeckImplementation(final List<Card> cardList) {
		super.addAll(cardList);
	}

	@Override
	public final boolean add(final Card arg0) {
		return super.add(arg0);
	}

	@Override
	public final void add(final int arg0, final Card arg1) {
		super.add(arg0, arg1);
	}

	@Override
	public final boolean addAll(final Collection<? extends Card> arg0) {
		return super.addAll(arg0);
	}

	@Override
	public final boolean addAll(final int arg0,
			final Collection<? extends Card> arg1) {
		return super.addAll(arg0, arg1);
	}

	@Override
	public final void clear() {
		super.clear();
	}

	@Override
	public final boolean contains(final Object arg0) {
		return super.contains(arg0);
	}

	@Override
	public final boolean containsAll(final Collection<?> arg0) {
		return super.containsAll(arg0);
	}

	@Override
	public final Card get(final int arg0) {
		return super.get(arg0);
	}

	@Override
	public final int indexOf(final Object arg0) {
		return super.indexOf(arg0);
	}

	@Override
	public final boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public final Iterator<Card> iterator() {
		return super.iterator();
	}

	@Override
	public final int lastIndexOf(final Object arg0) {
		return super.lastIndexOf(arg0);
	}

	@Override
	public final ListIterator<Card> listIterator() {
		return super.listIterator();
	}

	@Override
	public final ListIterator<Card> listIterator(final int arg0) {
		return super.listIterator(arg0);
	}

	@Override
	public final boolean remove(final Object arg0) {
		return super.remove(arg0);
	}

	@Override
	public final Card remove(final int arg0) {
		return super.remove(arg0);
	}

	@Override
	public final boolean removeAll(final Collection<?> arg0) {
		return super.removeAll(arg0);
	}

	@Override
	public final boolean retainAll(final Collection<?> arg0) {
		return super.retainAll(arg0);
	}

	@Override
	public final Card set(final int arg0, final Card arg1) {
		return super.set(arg0, arg1);
	}

	@Override
	public final int size() {
		return super.size();
	}

	@Override
	public final List<Card> subList(final int arg0, final int arg1) {
		return super.subList(arg0, arg1);
	}

	@Override
	public final Object[] toArray() {
		return super.toArray();
	}

	@Override
	public final <T> T[] toArray(final T[] arg0) {
		return super.toArray(arg0);
	}

	@Override
	public final Deck drawFromTop(final int count) {
		if (super.size() < count) {
			throw new InsufficientCardsException();
		}
		Deck r = new DeckImplementation(super.subList(0, count));
		for (int i = 0; i < count; i++) {
			super.remove(0);
		}
		return r;
	}

	@Override
	public final Card drawFromTop() {
		if (super.size() == 0) {
			throw new InsufficientCardsException();
		}
		return super.remove(0);
	}

	@Override
	public final Deck drawFromBottom(final int count) {
		if (super.size() < count) {
			throw new InsufficientCardsException();
		}
		Deck r = new DeckImplementation();
		for (int i = 0; i < count; i++) {
			r.add(0, super.remove(super.size() - 1));
		}
		return r;
	}

	@Override
	public final Card drawFromBottom() {
		if (super.size() == 0) {
			throw new InsufficientCardsException();
		}
		return super.remove(super.size() - 1);
	}

	@Override
	public final Deck drawAll() {
		Deck r = new DeckImplementation(this);
		super.clear();
		return r;
	}

	@Override
	public final void addToTop(final Deck deck) {
		super.addAll(0, deck);
	}

	@Override
	public final void addToTop(final Card card) {
		super.add(0, card);
	}

	@Override
	public final void addToBottom(final Deck deck) {
		super.addAll(deck);
	}

	@Override
	public final void addToBottom(final Card card) {
		super.add(card);
	}

	@Override
	public final Card peekTop() {
		return super.get(0);
	}

	@Override
	public final Card peekBottom() {
		return super.get(super.size() - 1);
	}

	@Override
	public final void shuffle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final Deck createUnmodifiableView() {
		throw new UnsupportedOperationException();
	}

}
